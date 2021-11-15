var MychartLabels = [];
var MychartData1 = [];
var MychartData2 = [];
		
		
		$.getJSON("http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/board/listData", function(Mydata){
			$.each(Mydata, function(inx, myobj){
				MychartLabels.push(myobj.imgName);
				MychartData1.push(myobj.uncut);
				MychartData2.push(myobj.spalling);
				});
			myCreateChart();
		})
		

		var myLineChartData = {
			labels : MychartLabels,
			datasets : [{
				label : "미절삭 섬유",
				type : 'line',
				backgroundColor: "#bfdaf9",
				borderColor: "#80b6f4",
				pointBorderColor: "#80b6f4",
				pointBackgroundColor: "#80b6f4",
				pointHoverBackgroundColor: "#80b6f4",
				pointHoverBorderColor: "#80b6f4",
				fill: false,
				borderWidth: 3,
				data : MychartData1
			},{
				label : "박리현상",
				type : 'line',
				backgroundColor: "#4e4e4e",
				borderColor: "#4e4e4e",
				pointBorderColor: "#4e4e4e",
				pointBackgroundColor: "#4e4e4e",
				pointHoverBackgroundColor: "#4e4e4e",
				pointHoverBorderColor: "#4e4e4e",
				fill: false,
				borderWidth: 3,
				data : MychartData2
			}]
		
		}
		function myCreateChart(){
			var ctx = document.getElementById("myCanvas").getContext("2d");
				LineChartDemo = Chart.Line(ctx,{
					data : myLineChartData,
					options : {
						scales : {
							yAxes : [{
								ticks : {
									beginAtZero : true
								}
							}]
						}
					}
			});
		
		}