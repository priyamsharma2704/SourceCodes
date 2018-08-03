const cafeList = document.querySelector('#cafe-list');
const form = document.querySelector('#add-cafe-form');

function renderCafe(doc)
{
  let li = document.createElement('li');
  let name = document.createElement('span');
  let city = document.createElement('span');
  let cross = document.createElement('div');
  
  li.setAttribute('data-id',doc.id);
  name.textContent = doc.data().Name;
  city.textContent = doc.data().City;
  cross.textContent = 'x';

  li.appendChild(name);
  li.appendChild(city);
  li.appendChild(cross);

  cafeList.appendChild(li);

  //deleting data
  cross.addEventListener('click', (e)=>{
    e.stopPropagation();
    let id = e.target.parentElement.getAttribute('data-id');
    db.collection('cafes').doc(id).delete();
  })
}

//getting datas
db.collection('cafes').orderBy('Name').get().then((snapshot)=>{
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