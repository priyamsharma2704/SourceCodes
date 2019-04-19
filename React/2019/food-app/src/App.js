import React, { Component, useEffect, useState } from 'react';
import './App.css';
import Recipe from './Recipe';



const App=()=>
{
  const APP_ID = "d7807ad1";
  const APP_KEY = "ecd9bb272373872ef38f3b25a0d4616b";

  const [recipes, setRecipes] = useState([]);
  const [search, setSearch] = useState("");
  const [query, setQuery] = useState("banana");

  useEffect(()=>{
    getRecipe();
  },[query]); //second parameter ie. empty array [] is for executing this function only 1 time when our app is rendered.
  
  const getRecipe = async ()=>{
    const response = await fetch(`https://api.edamam.com/search?q=${query}&app_id=${APP_ID}&app_key=${APP_KEY}`);
    const data = await response.json();
    console.log(data.hits);
    setRecipes(data.hits);
  }

  const getSearch=e=>
  {
    e.preventDefault();
    setQuery(search);
    setSearch("");
  }

  const updateSeacrch=e=>
  {
    setSearch(e.target.value);
  }
  

  return(
    <div className="App">
    <form onSubmit={getSearch} className="search-form">
      <input type="text" className="search-bar" value={search} onChange={updateSeacrch}/>
      <button type="submit" className="search-button">Search</button>
    </form>
    <div className="recipes">
    {recipes.map(recipe=>(
      <Recipe title={recipe.recipe.label} calories={recipe.recipe.calories} image={recipe.recipe.image} key={recipe.recipe.label} ingredients={recipe.recipe.ingredients}/>
    ))}
    </div>
    </div>

  );
}

export default App;
