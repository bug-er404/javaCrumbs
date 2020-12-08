import React, {Component} from 'react';
import Title from './Title';
import Clock from './Clock';
import '../style.css';

class Main extends Component{
    render(){
        return(  
        <div class = "clock-area">
            <Title title="London Clock"></Title>
            <Clock clock="ClockData">{Math.random()}</Clock>
        </div>
        )
        
    }
}
export default Main