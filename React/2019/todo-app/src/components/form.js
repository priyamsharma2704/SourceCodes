import React from 'react';

class Form extends React.Component
{
  render()
  {    
    return(
      <form onSubmit={this.props.getInput}>
        <div className="input-group mb-3">
        <input className="form-control" type="text" placeholder="Enter the task" name="task" value={this.props.inputValue}
        onChange={this.props.handleInputChange}/>
          <div className="input-group-append">
          <button className="btn btn-outline-secondary" >Submit</button>
          </div>
        </div>


        
      </form>
    );
  }
}

export default Form;