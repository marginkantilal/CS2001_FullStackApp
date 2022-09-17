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