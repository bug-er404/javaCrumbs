import React, {Component} from 'react';

export class Clock extends Component{
    int;
    onChangeTime = false;
    constructor(){
        super();
        this.state = 
        {
            hour:0,
            minute: 0,
            second: 0,
            option: true,
            hourEdit: false,
            minutesEdit: false,
            secondsEdit: false,
            optEdit: false
        };
        this.int = setInterval(this.addOne,1000);
    }

    addOne=()=>{
        var s = this.state.second;
        var m = this.state.minute;
        var h = this.state.hour;
        var o = this.state.option;
        s+=1;
        if(s===60)
        {
            s=0;
            m+=1;
        }
        if(m===60)
        {
            m=0;
            h+=1;
        }
        if(h===12)
        {
            h=0;
            o = !o;
        }
        this.setState({
            hour:h,
            minute:m,
            second:s,
            option:o
        });
    };


    changeTime=function(s, e)
    {
        clearInterval(this.int);
        switch(s)
        {
            case "o":
                {
                    this.setState({
                        optEdit: true
                    });
                    break;
                }
            case "h":
                {
                    this.setState({
                        hourEdit: true
                    });
                    break;
                }
            case "m":
                {
                    this.setState({
                        minutesEdit: true
                    });
                    break;
                }
            case "s":
                {
                    this.setState({
                        secondsEdit: true
                    });
                    break;
                }
            default:
                {
                break;
                }
        }
    };

    setTime =function(w, e)
    {
        console.log(w);
        var t;
        switch(w)
        {
            case "o":
                {
                    this.setState({
                        option: document.querySelector(".opt").value === "AM",
                        optEdit: false
                    });
                    break;
                }
            case "h":
                {
                    t = parseInt(document.querySelector(".hours").value);
                    document.querySelector(".hours").value = "";
                    if(t>0 && t<=12)
                    {
                        this.setState({
                            hour: t
                        });
                    }
                    this.setState({
                        hourEdit: false
                    });
                    break;
                }
            case "m":
                {
                    t = parseInt(document.querySelector(".minutes").value);
                    document.querySelector(".minutes").value = "";
                    if(t>0 && t<60)
                    {
                        this.setState({
                            minute: t
                        });
                    }
                    this.setState({
                        minutesEdit: false
                    });
                    break;
                }
            case "s":
                {
                    t = parseInt(document.querySelector(".seconds").value);
                    document.querySelector(".seconds").value = "";
                    if(t>0 && t<60)
                    {
                        this.setState({
                            second: t
                        });
                    }
                    this.setState({
                        secondsEdit: false
                    });
                    break;
                }
            default:
                {
                    break;
                }
        }
        this.int = setInterval(this.addOne,1000);
    };

    render(){
        return( 
                <div className="timer">
                    <label>
                        <input
                        className="hours"
                        onBlur={this.setTime.bind(this, "h")}
                        hidden = {!this.state.hourEdit}/>
                        <span 
                        onClick={this.changeTime.bind(this,"h")}
                        hidden={this.state.hourEdit}>
                            {this.state.hour<10?0:null}
                            {this.state.hour}
                        </span>
                    </label>
                    :
                    <label>
                        <input
                        className="minutes"
                        onBlur={this.setTime.bind(this, "m")}
                        hidden = {!this.state.minutesEdit}/>
                        <span 
                        onClick={this.changeTime.bind(this,"m")}
                        hidden={this.state.minutesEdit}>
                            {this.state.hour<10?0:null}
                            {this.state.hour}
                        </span>
                    </label>       
                    :
                    <label>
                        <input
                        className="seconds"
                        onBlur={this.setTime.bind(this, "s")}
                        hidden = {!this.state.secondsEdit}/>
                        <span 
                        onClick={this.changeTime.bind(this,"s")}
                        hidden={this.state.secondsEdit}>
                            {this.state.hour<10?0:null}
                            {this.state.hour}
                        </span>
                    </label> 
                    <label>
                        <select
                        className="opt"
                        onBlur={this.setTime.bind(this, "o")}
                        hidden={!this.state.changingOpt}
                        >
                        <option value="AM">AM</option>
                        <option value="PM">PM</option>
                        </select>
                        <span
                            onClick={this.changeTime.bind(this, "o")}
                            hidden={this.state.changingOpt}
                        >
                            {this.state.option ? "AM" : "PM"}
                    </span>
                    </label>
                </div>
        );
        
    }
}
