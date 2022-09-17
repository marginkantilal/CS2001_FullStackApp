$('#table').BootstrapTable({});
function thisMonth()
{
    document.getElementById('monthYear').innerHTML='Ranking this month';
    
    var data=[{
        id: '1',
        pic: 'pic1',
        name: 'Kamil',
        food: '38'
    }, {
        id: '2',
        pic: 'pic2',
        name: 'Marek',
        food: '22'
    }, {
        id: '3',
        pic: 'pic3',
        name: 'Kamil',
        food: '88'
    }, {
        id: '3',
        pic: 'pic3',
        name: 'Kamil',
        food: '88'
    }, {
        id: '3',
        pic: 'pic3',
        name: 'Kamil',
        food: '88'
    }, {
        id: '3',
        pic: 'pic3',
        name: 'Kamil',
        food: '88'
    }];

    $('#table').BootstrapTable("load", data);
}

function thisYear()
{
    document.getElementById('monthYear').innerHTML='Ranking this year';
}

function donateMore()
{
    window.open("donate.html");
    
}

function backToFood()
{
    window.location.replace("foodwaste.html");
}

function sortTable()
{
    var table = document.getElementById('table').getElementsByTagName('tbody').item(0);

    var row = table.getElementsByTagName('tr');

    for(var i=0;i<row.length-1;i++) 
    {  
        for(var j=0;j<row.length-(i+1);j++) 
        {
            if(parseInt(row.item(j).getElementsByTagName('td').item(3).innerHTML)>parseInt(row.item(j+1).getElementsByTagName('td').item(3).innerHTML)) 
            {
                table.insertBefore(row.item(j+1),row.item(j));
            }
        }
    }
}



//Get Restaurant Record By Restaurant Name
function getMostDonation(){

    var resultElement = document.getElementById('resultElement');
    var table = document.getElementById('table');
    
    resultElement.innerHTML = '';
axios({
        method: 'get',
        url: 'http://localhost:8080/mostdonation/',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
    })
    .then((response) => {
           
        resultElement.innerHTML = generateSuccessHTMLOutput(response);

    })
    .catch(function (error) {
        resultElement.innerHTML = generateErrorHTMLOutput(error);
     });
   
}


//To add Restaurant To Make Donation
function performAddRequest() {
    var name = document.getElementById('name-field').value;
    var address = document.getElementById('address-field').value;
    var phonenumber = document.getElementById('phone-field').value;
    var resultElement = document.getElementById('postResultElement');
    resultElement.innerHTML = '';
    axios({
        method: 'post',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        url: 'http://localhost:8080/api/restaurants/add/restaurant',
        
        data: {
            name, //value to be stored in the database
            address, //value to be stored in the database
            phonenumber //value to be stored in the database
        }
  })
  .then(function (response) {
    resultElement.innerHTML = generateSuccessHTMLOutput(response);
  })
  .catch(function (error) {
    resultElement.innerHTML = generateErrorHTMLOutput(error);
  });

}


   
//Shows Successful message 
function generateSuccessHTMLOutput(response) {
    return  '<h4>Result:</h4>' +
            '<h5>Status:</h5>' +
            '<pre>' + response.status + " "+  "Successfully Done"+ ' ' + response.statusText + '</pre>' +
            '<h5>Record:</h5>' +
            '<pre>' + JSON.stringify(response.data, null, '\t') + '</pre>';
  }