db.collection('cafes').get().then((snapshot)=>{
  snapshot.docs.forEach(doc=>{
    console.log(doc);
  })
  //console.log(snapshot.docs);
})