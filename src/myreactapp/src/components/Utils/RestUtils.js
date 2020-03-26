export const baseURL = "http://localhost:8080";
export const postRequest =(action,data,onDataReceive) =>{
    fetch(new Request(baseURL+'/services/'+action),
    {
      headers:{
        'Content-Type': 'application/json',
      },
       method: 'POST',
       body: JSON.stringify(data) 
      
    }
       )

  .then((res)=>res.json())
  .then(data=>{
    onDataReceive(data);
  });
}


export const getRequest =(action,onDataReceive) =>{
  fetch(new Request(baseURL+'/services/'+action),
  {
     method: 'GET'
  }
     )

.then((res)=>res.json())
.then(data=>{
  onDataReceive(data);
});
}