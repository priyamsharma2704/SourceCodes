import React from 'react';

class Form extends React.Component
{
  render()
  {    
    return(
      <form onSubmit={this.props.getInput}>
        <input type="text" placeholder="Enter the task" name="task" value={this.props.inputValue}
        onChange={this.props.handleInputChange}/>
        <button >Submit</button>
      </form>
    );
  }
}

export default Form;