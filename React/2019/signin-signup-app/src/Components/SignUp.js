import React, {Component} from 'react';

class SignUp extends Component
{
	render()
	{
		return(
			<div className="signup">
				<br/>
				<input type="text" placeholder="Name"/><br/>
				<input type="email" placeholder="Email"/><br/>
				<input type="password" placeholder="Password"/>
			</div>
		);
	}	
}

export default SignUp;