// Read from url the param my-modal and show the modal
var url = new URL(window.location.href);
var myModal = url.searchParams.get("my-modal");
var restaurantId = url.searchParams.get("restaurant-id");
var quantity = url.searchParams.get("quantity");
var description = url.searchParams.get("description");

//selecting modal by its id
const divModal = document.getElementById("modal-success");

//to keep the modal hidden from the user until the condition is met
//keeping the modal hidden from the user
if (divModal) {
    divModal.style.display = "none";
}

//if all this condition to be true then show modal
if (divModal && myModal && (myModal === "true")) {

/* Save values in database (post donation) */ 
    axios({
        method: 'post',
        url: 'http://localhost:8080/add/donations/' + restaurantId,
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        },
        data: {
            quantity, //value to be stored in the database
            description //value to be stored in the database
        }
      
      })
      .then((res) => {
        if (res && res.data) {
            // const data = JSON.parse(res.data);
            console.log(typeof data);
            console.log(res.data);
        }
      
      })
      .catch((err) => {
          console.window(err);
       });

       /* End - Save values in database (post donation) */

      
    divModal.style.display = "block";
    //displays the success modal
}
//to close the modal and display donate page once clicked
function closeModal() {
    window.location.href = "/donate.html";

}

