b1.onclick = () => {
    let url = "http://localhost:8080/Shivubank_project1/accountcreation";
    fetch(url,{
        method : 'POST', body: JSON.stringify({
            customerid : 1 ,
            accounttype : document.getElementById('accounttype').value,
            accountbalance : document.getElementById('accountbalance').value,
            customeraadharno : document.getElementById('aadhar').value
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
          }

    });
    alert("Account created Successfully");
    location.href="welcomecustomer.html";
}

// b2.onclick = () => {
//     let url = "http://localhost:8080/Shivubank_project1/accountcreation";
//     fetch(url)
//         .then(response => response.json())
//         .then(e => {
//             let data = "<table class='table table-striped table-bordered'> <thead class='thead-dark'> <tr><th>CustomerId</th><th>AccountType</th><th>AccountNo</th><th>AccountBalance</th><th>AccountStatus</th><th>CustomerAadharNo</th></thead><tbody>" //<th>Customerpassword</th>
            
//                 data = data + "<tr><td>" + e.customerid + "</td>";
//                 data = data + "<td>" + e.accounttype + "</td>";
//                 data = data + "<td>" + e.customeraccountno + "</td>";
//                 data = data + "<td>" + e.accountbalance + "</td>";
//                 data = data + "<td>" + e.accountstatus + "</td>";
//                 data = data + "<td>" + e.customeraadharno + "</td>";
           
//             data = data + "</tr></tbody></table>";
//             document.getElementById("result").innerHTML = data;
//         })
//     }