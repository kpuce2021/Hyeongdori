var chartLabel3 = [];
var firstData3 = [];
var secondData3 = [];
      
      
$.getJSON("http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/board/chartByMonth", function(data3){
   $.each(data3, function(inx, obj3){
   	  var date1 = obj3.days.slice(0, 4)+'-'+obj3.days.slice(4, 6);
      chartLabel3.push(date1);
      firstData3.push(obj3.avgOfUncut);
      secondData3.push(obj3.avgOfSpalling);
      });
   createChart3();
})
      

var lineChartData3 = {
   labels : chartLabel3,
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
      data : firstData3
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
      data : secondData3
   }]
      
}
function createChart3(){
   var ctx3 = document.getElementById("canvas3").getContext("2d");
      LineChartDemo = Chart.Line(ctx3,{
         data : lineChartData3,
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