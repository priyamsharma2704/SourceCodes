const cafeList = document.querySelector('#cafe-list');
const form = document.querySelector('#add-cafe-form');

function renderCafe(doc)
{
  let li = document.createElement('li');
  let name = document.createElement('span');
  let city = document.createElement('span');

  li.setAttribute('data-id',doc.id);
  name.textContent = doc.data().Name;
  city.textContent = doc.data().City;

  li.appendChild(name);
  li.appendChild(city);
console.log(li);
  cafeList.appendChild(li);
}

//getting datas
db.collection('cafes').get().then((snapshot)=>{
  snapshot.docs.forEach(doc=>{
    console.log(doc.data());
    renderCafe(doc);
  })
  //console.log(snapshot.docs);
})

//saving data
form.addEventListener('submit',(e)=>{
  e.preventDefault();
  db.collection('cafes').add({
    Name : form.Name.value, 
    City : form.City.value
  });
  form.Name.value ="";
  form.City.value = "";
})