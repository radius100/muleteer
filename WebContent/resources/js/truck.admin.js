	var muleNumber;
	var muleURL;
	var muleConnectionURLTemplate = "http://"+location.host+"/tracking/mule-";
	
	
$(document).ready(function() {

		$("[id*='conn-']").click(function() {
			muleNumber = $(this).attr("id").substring(5);
			muleURL=muleConnectionURLTemplate+muleNumber;
			
			$("#qr").empty();
			$("#qr").ClassyQR({
				create : true,
				size : 200,
				type : 'url',
				url : muleURL
			});
			
			$("#myModal").modal('show');
			updateMule(muleNumber);
		});
		
		function updateMule(n) {
			var name = $('#name-'+n).val();
			var status = $("#active-"+n).is(':checked') ? 'active' : 'disabled';
			
			var addr = "http://"+location.host+location.pathname+"/mule-"+n;
			
			$.post(addr,
				{
					name: name,
					status: status
				},
				function(data, status){
			 });
		}

		$("[id*='name-']").blur(function(){
			n = $(this).attr("id").substring(5);
			updateMule(n);
		});

		$("[id*='active-']").click(function() {
			n = $(this).attr("id").substring(7);
			updateMule(n);
		});
	});
