import React from 'react';

class List extends React.Component
{

  render()
  {
    return(
      <div>
        {this.props.taskList.map((task, index)=>{
          return(
            <div className="list-group-item" 
              key={index}
              style={{cursor:'pointer'}}
              title="Click to mark as done."
              onClick={()=>this.props.handleClick(index)}>
              <span style={{textDecoration: task.done ? 'line-through':'none',color:task.done? "red" : "black"}}>{task.value}</span>
            </div>
            );
        })}
      </div>
    );
  }
}

export default List;