//$('#table').BootstrapTable({});



function thisMonth()
{
    //$('#table').BootstrapTable("load", data);
    document.getElementById('monthYear').innerHTML='Ranking this month';
}
function thisYear()
{
    document.getElementById('monthYear').innerHTML='Ranking this year';
}

/*this method runs on load of webpage*/
function onLoad()
{
    sortTable();

}
/*
function foodDonated()
{
    var ourRequest = new XMLHttpRequest(); 
    var id=2;
    var sum=0; 
    ourRequest.open('GET','http://localhost:8080/restaurants/'+id+'/donations');

    ourRequest.onload = function()
    {
    var data = JSON.parse(ourRequest.responseText);

    ourRequest.send();

    for(i=0;i<data.length;i++)
    {
        sum=sum+data[i][1];
    }

    document.getElementById('foodDonated').innerHTML=sum;
}
*/

/*donate more button*/
function donateMore()
{
    var cookieValue=document.getElementById('donateNo').value;
    document.cookie = "value"+"="+cookieValue;

    window.open("donate.html");
}

/*back to food page button*/
function backToFood()
{
    window.location.replace("foodwaste.html");
}
/*method sorting leaderboard table*/
function sortTable()
{
    var table = document.getElementById('table').getElementsByTagName('tbody').item(0);

    var row = table.getElementsByTagName('tr');

    for(var i=0;i<row.length-1;i++) 
    {  
        for(var j=0;j<row.length-(i+1);j++) 
        {
            if (row.item(j).getElementsByTagName('td').item(3) && row.item(j+1).getElementsByTagName('td').item(3)) {
                if(parseInt(row.item(j).getElementsByTagName('td').item(3).innerHTML) > parseInt(row.item(j+1).getElementsByTagName('td').item(3).innerHTML)) 
                {
                    table.insertBefore(row.item(j+1),row.item(j));
                }
            }
        }
    }
}

var ourRequest = new XMLHttpRequest();  //establish connection with url specified
ourRequest.open('GET','http://localhost:8080/mostdonation');

ourRequest.onload = function()
{
    var data = JSON.parse(ourRequest.responseText);
    renderList(data);
};
ourRequest.send();

/*method rendering list of the data*/
function renderList(data)
{
    // Validate if data exists
    if (data && data.length) {
        // Iterate into data and insert in each row of table, restaurant (data[i][0]) and amount (data[i][1]) 
        for(var i=0; i<data.length;i++)
        {
            insertion(i, data[i][0], data[i][1]);
        }    
    }

    //document.getElementById("list").appendChild("li1");
}

/* method inserting splitted data into the leaderboard table*/
function insertion(i, restaurant_name, food)
{
  var table = document.getElementById("table");

  // New row tag html (tr)
  const row = document.createElement("tr");

  // reate 3 columns (tds)
  const cell1 = document.createElement("td");
  const cell2 = document.createElement("td");
  const cell3 = document.createElement("td");

  // Putting the values in columns (id, restaurant, food)
  cell1.innerHTML = i+1;
  cell2.innerHTML = restaurant_name;
  cell3.innerHTML = food;

  // Putting the 3 columns into one row
  row.appendChild(cell1);
  row.appendChild(cell2);
  row.appendChild(cell3);

  // Putting the row into the table
  table.appendChild(row);

  // Friend methof add row starts here
//   var row= table.insertRow(1);

//   var cell1 = row.insertCell(0);
//   var cell2 = row.insertCell(1);
//   var cell3 = row.insertCell(2);

//   cell1.innerHTML = i+1;
//   cell2.innerHTML = restaurant_name;
//   cell3.innerHTML = food;
  // End - Friend methof add row starts here

 // sortTable();
} 




