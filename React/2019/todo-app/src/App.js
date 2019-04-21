import React, { Component } from 'react';
import './App.css';
import Form from './components/form';
import List from './components/list';

class App extends Component {
  state={
    inputValue:"",
    tasks: []
  }

  getInputValue=(e)=>
  {
    e.preventDefault();

    const inputVal = e.target.elements.task.value;
    const dummyTask = {
      value : inputVal,
      done:false
    }
    const todos = this.state.tasks;
    todos.push(dummyTask);

    if(inputVal)
    {
      this.setState(
        {
          tasks:todos,
          inputValue:" "
        }
      );
    }
    
  }

  HandleClick=(index)=>
  {
    const todos = this.state.tasks;
    todos[index].done = ! todos[index].done;
    this.setState({
      tasks:todos
    });
  }

  HandleInputChange=(e)=>
  {
    this.setState(
      {
        inputValue:e.target.value
      }
    );
  }
  
  render() {
    return (
      <div>
        <Form getInput={this.getInputValue} 
          inputValue={this.state.inputValue}
          handleInputChange={this.HandleInputChange}></Form>
        <List handleClick={this.HandleClick} 
          taskList={this.state.tasks}></List>
      </div>
    );
  }
}

export default App;
