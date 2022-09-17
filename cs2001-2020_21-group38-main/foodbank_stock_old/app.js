//Select DOM
const stockInput = document.querySelector(".stock-input");
const stockButton = document.querySelector(".stock-button");
const stockList = document.querySelector(".stock-list");
const filterOption = document.querySelector(".filter-stock");

//Event Listeners
document.addEventListener("DOMContentLoaded", getStocks);
stockButton.addEventListener("click", addStock);
stockList.addEventListener("click", deleteStock);
filterOption.addEventListener("click", filterStock);

//Functions

function addStock(e) {
  //Prevent natural behaviour
  e.preventDefault();
  //Create stock div
  const stockDiv = document.createElement("div");
  stockDiv.classList.add("stock");
  //Create list
  const newStock = document.createElement("li");
  newStock.innerText = stockInput.value;
  //Save to local - do this last
  //Save to local
  saveLocalStocks(stockInput.value);
  //
  newStock.classList.add("stock-item");
  stockDiv.appendChild(newStock);
  stockInput.value = "";
  //Create Completed Button
  const completedButton = document.createElement("button");
  completedButton.innerHTML = `<i class="fas fa-check"></i>`;
  completedButton.classList.add("complete-btn");
  stockDiv.appendChild(completedButton);
  //Create trash button
  const trashButton = document.createElement("button");
  trashButton.innerHTML = `<i class="fas fa-trash"></i>`;
  trashButton.classList.add("trash-btn");
  stockDiv.appendChild(trashButton);
  //attach final Stock
  stockList.appendChild(stockDiv);
}

function deleteStock(e) {
  const item = e.target;

  if (item.classList[0] === "trash-btn") {
    // e.target.parentElement.remove();
    const stock = item.parentElement;
    stock.classList.add("fall");
    //at the end
    removeLocalStocks(stock);
    stock.addEventListener("transitionend", e => {
      stock.remove();
    });
  }
  if (item.classList[0] === "complete-btn") {
    const stock = item.parentElement;
    stock.classList.toggle("completed");
    console.log(stock);
  }
}

function filterStock(e) {
  const stocks = stockList.childNodes;
  stocks.forEach(function(stock) {
    switch (e.target.value) {
      case "all":
        stock.style.display = "flex";
        break;
      case "completed":
        if (stock.classList.contains("completed")) {
          stock.style.display = "flex";
        } else {
          stock.style.display = "none";
        }
        break;
      case "uncompleted":
        if (!stock.classList.contains("completed")) {
          stock.style.display = "flex";
        } else {
          stock.style.display = "none";
        }
    }
  });
}

function saveLocalStocks(stock) {
  let stocks;
  if (localStorage.getItem("stocks") === null) {
    stocks = [];
  } else {
    stocks = JSON.parse(localStorage.getItem("stocks"));
  }
  stocks.push(stock);
  localStorage.setItem("stocks", JSON.stringify(stocks));
}
function removeLocalStocks(stock) {
  let stocks;
  if (localStorage.getItem("stocks") === null) {
    stocks = [];
  } else {
    stocks = JSON.parse(localStorage.getItem("stocks"));
  }
  const stockIndex = stock.children[0].innerText;
  stocks.splice(stocks.indexOf(stockIndex), 1);
  localStorage.setItem("stocks", JSON.stringify(stocks));
}

function getStocks() {
  let stocks;
  if (localStorage.getItem("stocks") === null) {
    stocks = [];
  } else {
    stocks = JSON.parse(localStorage.getItem("stocks"));
  }
  stocks.forEach(function(stock) {
    //Create stock div
    const stockDiv = document.createElement("div");
    stockDiv.classList.add("stock");
    //Create list
    const newStock = document.createElement("li");
    newStock.innerText = stock;
    newStock.classList.add("stock-item");
    stockDiv.appendChild(newStock);
    stockInput.value = "";
    //Create Completed Button
    const completedButton = document.createElement("button");
    completedButton.innerHTML = `<i class="fas fa-check"></i>`;
    completedButton.classList.add("complete-btn");
    stockDiv.appendChild(completedButton);
    //Create trash button
    const trashButton = document.createElement("button");
    trashButton.innerHTML = `<i class="fas fa-trash"></i>`;
    trashButton.classList.add("trash-btn");
    stockDiv.appendChild(trashButton);
    //attach final Stock
    stockList.appendChild(stockDiv);
  });
}
