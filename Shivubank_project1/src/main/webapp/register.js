b1.onclick = () => {
    let url = "http://localhost:8080/Shivubank_project1/customerregistration";
    fetch(url,{
        method : 'POST', body: JSON.stringify({
            customername : document.getElementById('name').value,
            customerphoneno : document.getElementById('phoneno').value,
            customergender : document.getElementById('gender').value,
            customeremailid : document.getElementById('email').value,
            customerpassword : document.getElementById('password').value,
            customerpancard : document.getElementById('pancard').value
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
          }

    });
    alert("Registration Details Inserted Successfully")
    location.href="loginC.html";
}