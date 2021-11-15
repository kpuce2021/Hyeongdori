var chartLabels = [];
var chartData1 = [];
var chartData2 = [];
		
		
$.getJSON("http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/board/allListData", function(data){
	$.each(data, function(inx, obj){
		var date2 = obj.imgName.slice(0, 4)+'-'+obj.imgName.slice(4, 6)+'-'+obj.imgName.slice(6, 8)+' '+obj.imgName.slice(8, 10)+':'+obj.imgName.slice(10, 12)+':'+obj.imgName.slice(12, 14);
		chartLabels.push(date2);
		chartData1.push(obj.uncut);
		chartData2.push(obj.spalling);
		});
	createChart();
})
		

var lineChartData = {
	labels : chartLabels,
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
		data : chartData1
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
		data : chartData2
	}]
		
}
function createChart(){
	var ctx = document.getElementById("canvas").getContext("2d");
		LineChartDemo = Chart.Line(ctx,{
			data : lineChartData,
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