import React, { Component } from "react";

export class Clock extends Component {
  int;
  onChangeTime = false;
  constructor() {
    super();
    this.state = {
      hour: 0,
      minutes: 0,
      second: 0,
      editHour: false,
      editMinute: false,
      editSecond: false,
      editOption: false,
      option: true
    };
    this.int = setInterval(this.addOne, 1000);
  }

  addOne = () => {
    var s = this.state.second;
    var m = this.state.minutes;
    var h = this.state.hour;
    var o = this.state.option;
    s += 1;
    if (s === 60) {
      s = 0;
      m += 1;
    }
    if (m === 60) {
      m = 0;
      h += 1;
    }
    if (h === 12) {
      h = 0;
      o = !o;
    }
    this.setState({
      hour: h,
      minutes: m,
      second: s,
      option: o
    });
  };


  changeTime = function(s, e) {
    clearInterval(this.int);
    switch (s) {
      case "o": {
        this.setState({
          changingOpt: true
        });
        break;
      }
      case "h": {
        this.setState({
          editHour: true
        });
        break;
      }
      case "m": {
        this.setState({
          editMinute: true
        });
        break;
      }
      case "s": {
        this.setState({
          editSecond: true
        });
      }
    }
  };

  setTime = function(w, e) {
    console.log(w);
    switch (w) {
      case "o": {
        this.setState({
          option: document.querySelector(".opt").value === "AM"
        });
        this.setState({
          changingOpt: false
        });
        break;
      }
      case "h": {
        var t = parseInt(document.querySelector(".hour").value);
        document.querySelector(".hour").value = "";
        if (t > 0 && t <= 12) {
          this.setState({
            hour: t
          });
        }
        this.setState({
          editHour: false
        });
        break;
      }
      case "m": {
        var t = parseInt(document.querySelector(".min").value);
        document.querySelector(".min").value = "";
        if (t > 0 && t <= 60) {
          this.setState({
            minutes: t
          });
        }
        this.setState({
          editMinute: false
        });
        break;
      }
      case "s": {
        var t = parseInt(document.querySelector(".sec").value);
        document.querySelector(".sec").value = "";
        if (t > 0 && t <= 60) {
          this.setState({
            second: t
          });
        }
        this.setState({
          editSecond: false
        });
      }
    }
    this.int = setInterval(this.addOne, 1000);
  };

  render() {
    return (
      <div className="container">
        <p className="title">London Clock</p>
        <label>
          <input
            className="hour"
            onBlur={this.setTime.bind(this, "h")}
            hidden={!this.state.editHour}
          />
          <span
            onClick={this.changeTime.bind(this, "h")}
            hidden={this.state.editHour}
          >
            {this.state.hour < 10 ? 0 : null}
            {this.state.hour}
          </span>
        </label>
        :
        <label>
          <input
            className="min"
            onBlur={this.setTime.bind(this, "m")}
            hidden={!this.state.editMinute}
          />
          <span
            onClick={this.changeTime.bind(this, "m")}
            hidden={this.state.editMinute}
          >
            {this.state.minutes < 10 ? 0 : null}
            {this.state.minutes}
          </span>
        </label>
        :
        <label>
          <input
            className="sec"
            onBlur={this.setTime.bind(this, "s")}
            hidden={!this.state.editSecond}
          />
          <span
            onClick={this.changeTime.bind(this, "s")}
            hidden={this.state.editSecond}
          >
            {this.state.second < 10 ? 0 : null}
            {this.state.second}
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



    // componentDidMount(){
    //     this.timer = setInterval(() => this.setState({date: new Date()}),1000);
    //     this.setState({
    //         hour: this.state.date.getHours(),
    //         minute: this.state.date.getMinutes(),
    //         second: this.state.date.getMinutes(),
    //         option:false,
    //         isInEditMode: false,
    //         hourEdit: false,
    //         minutesEdit: false,
    //         secondsEdit: false,
    //         optEdit: false
    //     });
    // }
    // componentWillUnmount(){
    //     clearInterval(this.timer);
    // }
    // renderDefaultView=()=>
    // {
    //     return( 
    //         <div className="clock">
    //             <div className="timer">
    //                 <span id="hours" onDoubleClick={this.changeHours()}>{this.state.date.getHours()}</span>
    //                 :
    //                 <span id="minutes" onDoubleClick={this.changeMinutes()}>{this.state.date.getMinutes()}</span>
    //                 :
    //                 <span id="seconds" onDoubleClick={this.changeSeconds()}>{this.state.date.getSeconds()}</span>
    //                 <span id="tod">{(this.state.date.getHours()>=12)? " PM":" AM"}</span>
    //             </div>
    //         </div>
    //     )
    // }