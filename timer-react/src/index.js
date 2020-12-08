
import React, {Component} from 'react';
import {render} from 'react-dom';
import Title from './components/Title';
import {Clock} from './components/Clock';
import './style.css';

class App extends Component{
    constructor(){
        super();
        this.state={
            name:"React"
        };
    }
    render(){
        return(  
        <div className = "clock-area">
            <Clock/>
        </div>
        )
        
    }
}
render(<App/>, document.getElementById("root"));