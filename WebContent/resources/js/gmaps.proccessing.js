	var map;
	var directionsService;
	var directionsDisplay;
	var markers = [];

	function initMap() {

		map = new google.maps.Map(document.getElementById('map'), {
			zoom : 12,
			center : {
				lat : -25.7478676,
				lng : 28.2292712
			},
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});

		directionsService = new google.maps.DirectionsService;
		directionsDisplay = new google.maps.DirectionsRenderer({
			draggable : true,
			map : map
		});

		directionsDisplay.addListener('directions_changed', function() {
			computeTotalDistance(directionsDisplay.getDirections());
		});

		displayRoute(-25.74255805, 28.22213227, 'gezina pretoria, sars',
				directionsService, directionsDisplay);
	}

	function displayRoute(originLat, originLng, destination, service, display) {
		service.route({
			origin : new google.maps.LatLng(originLat, originLng),
			destination : destination,
			travelMode : google.maps.TravelMode.DRIVING,
			avoidTolls : true
		}, function(response, status) {
			if (status === google.maps.DirectionsStatus.OK) {
				display.setDirections(response);
			} else {
				alert('Could not display directions due to: ' + status);
			}
		});

	}

	function computeTotalDistance(result) {
		var total = 0;
		var myroute = result.routes[0];
		for (var i = 0; i < myroute.legs.length; i++) {
			total += myroute.legs[i].distance.value;
		}
		total = total / 1000;
		document.getElementById('total').innerHTML = total + ' km';
	}

	function updateMarkersOnMap() {
		var url = "http://"+location.host+location.pathname+"get-markers";

		$.getJSON(url, function(datas, status) {
			for (var i = 0; i < markers.length; i++) {
				if(markers[i] != null)
					markers[i].setMap(null);
			}
			if (datas != null) {
				datas.forEach(function(data, i, datas) {
					var position = new google.maps.LatLng(data.lat, data.lng);
					var marker = new google.maps.Marker({
						position : position,
						title : data.name,
						icon : 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png',
						map : map
					});
					markers[data.id]=marker;
				});
			}
		});
	}

	$(document).ready(function() {
		setInterval(updateMarkersOnMap, 30000);

		$('#refresh').click(function() {
			updateMarkersOnMap();
		});

		$('#dest').click(function() {
			addr = $('#address').val();
			var i = $(":checked").val();

			if(i >= 0 && addr.length > 0)
				displayRoute(markers[i].position.lat(), markers[i].position.lng(),
					addr, directionsService, directionsDisplay);
		});

		$('#find').click(function() {
			var i = $(":checked").val();

			if(i>=0) {
				var marker = markers[i];
				markers[i].setMap(null);

				if(marker.getPosition().lat() != 0 && marker.getPosition().lng() != 0){
					map.setCenter(marker.getPosition());
					marker.setIcon('http://maps.google.com/mapfiles/ms/icons/yellow-dot.png')
					marker.setMap(map);
				}
				else
					alert('No coordinates avaible yet for this truck!');
			}
		});
	});
