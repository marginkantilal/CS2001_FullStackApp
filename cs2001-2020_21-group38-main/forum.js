
/*method posting data to create new topic*/
function createTopic()
{
      var category = $("#selectCategoryC").val();
      var topic = $("#topicNameC").val();
      var textField = $("#discussionFieldC").val();
  
      //var dataString = 'category='+ category + '&topic=' + topic + '&text=' + textField;
     
      $.ajax(
      {
          type : 'POST', 
          url  : 'forumController.php', 
          data : {
            category: category, 
            topic: topic, 
            textField: text
          }, 
          success: function(response)
          {
            jQuery('#forumTable tbody').append('<tr><td>category');
          }
            
      });
}
  
/*method to search for existing topics*/
function searchTopic()
{
  var cat = document.getElementById("selectCategoryS").value;
  var topicName = document.getElementById("keywordS").value;
}

/*filtering table by user input*/
function filterTable() {
    var input, filter, table, tr, td, i;

    input = document.getElementById("organisation");
    filter = "organisation";

    table = document.getElementById("forumTable");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) 
    {
      td = tr[i].getElementsByTagName("td")[2];
      if (td) 
      {
        txtValue = td.textContent || td.innerText;
        if (txtValue.indexOf(filter) > -1) 
        {
          tr[i].style.display = "";
        } 
        else 
        {
          tr[i].style.display = "none";
        }
      }       
    }

  
}

/*parsing data from backend to the list of topics*/
function fillForumTable()
{
  var ourRequest = new XMLHttpRequest();  //establish connection
  ourRequest.open('GET','http://localhost:8080/forumTable.php');

  ourRequest.onload = function()
  {
    var data = JSON.parse(ourRequest.responseText);
    renderList(data);
  };
  ourRequest.send();


}