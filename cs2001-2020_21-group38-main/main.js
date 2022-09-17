//after validation is checked, display the success modal
function checkValidation() {
    /* Handle Modal open */
    const inputModal = document.getElementById("my-modal");//getting the modal using its id
    if (inputModal) { inputModal.value = "true"; } //used for url href
    /* End - Handle Modal open */
    
}

function onLoad() 
{
    var decodedCookie = decodeURIComponent(document.cookie);  //get cookie
    var splittedCookie = decodedCookie.split(';');

    document.getElementById('quantity-field').value=splittedCookie[0].substring(splittedCookie[0].indexOf('=')+1);
}



//Get Restaurant Record By Restaurant Name
function getRestaurant(){

    var resultElement = document.getElementById('resultElement');
    var resName = document.getElementById('name-field').value;
    
    resultElement.innerHTML = '';
axios({
        method: 'get',
        url: 'http://localhost:8080/restaurant/'+resName,
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


      //Shows error message 
      function generateErrorHTMLOutput(error) {
        return  '<h4>Result:</h4>' +
                '<h5>Status:</h5>' +
                '<pre>' + error.response.status + ' ' + " " + "Failed" + error.response.statusText + '</pre>' +
                '<h5>Data:</h5>' +
                '<pre>' + JSON.stringify(error.response.data, null, '\t') + '</pre>';
      }

//***************************Working*******************************
// axios({
//         method: 'get',
//         url: 'http://localhost:8080/restaurants/donations',
//         headers: {
//             'Access-Control-Allow-Origin': '*',
//             'Content-Type': 'application/json',

//         }

//     })
//     .then((res) => {
//         if (res && res.data) {
//             const data = JSON.parse(res.data);
//             console.log(typeof data)
//             console.log(res.data);
//         }

//     })
//     .catch((err) => { throw err });

