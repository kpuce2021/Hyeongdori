var chartLabel = [];
var firstData = [];
var secondData = [];
		
		
$.getJSON("http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/board/charByDay", function(data1){
	$.each(data1, function(inx, obj1){
		var date = obj1.days.slice(0, 4)+'-'+obj1.days.slice(4, 6)+'-'+obj1.days.slice(6, 8);
		chartLabel.push(date);
		firstData.push(obj1.avgOfUncut);
		secondData.push(obj1.avgOfSpalling);
		});
	createChart1();
})
		

var lineChartData1 = {
	labels : chartLabel,
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
		data : firstData
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
		data : secondData
	}]
		
}
function createChart1(){
	var ctx1 = document.getElementById("canvas2").getContext("2d");
		LineChartDemo = Chart.Line(ctx1,{
			data : lineChartData1,
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