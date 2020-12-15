function _defineProperty(obj, key, value) {if (key in obj) {Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true });} else {obj[key] = value;}return obj;}class App extends React.Component
{constructor(...args) {super(...args);_defineProperty(this, "state",
    { tasks: ['default task 1', 'task 2', 'another one 3'],
      filter: "" });_defineProperty(this, "handleDelete",


    index => {
      const newArr = [...this.state.tasks];
      newArr.splice(index, 1);
      this.setState({ tasks: newArr });
    });_defineProperty(this, "handleAdd",

    task => {
      if (this.state.tasks.indexOf(task) == -1)
      {
        this.setState({ tasks: [...this.state.tasks, task] });
      }
    });_defineProperty(this, "filterList",

    nameFilter => {
      this.setState({ filter: nameFilter });
      // let filteredList = this.state.tasks
      // filteredList = filteredList.filter((task)=>{
      //   let taskName = task.toLowerCase()
      //   console.log(this.state.tasks.includes(taskName));
      //   return this.state.tasks.includes(taskName);
      // })
      //   this.state.tmpTasks = this.state.tasks;
      //   this.state.tasks = filteredList;
    });}

  render() {
    return (
      React.createElement("div", { className: "wrapper" },
      React.createElement("div", { className: "card frame" },
      React.createElement(Header, { todosCount: this.state.tasks.length }),
      React.createElement(SubmitForm, { onFormSubmit: this.handleAdd }),
      React.createElement(FilterList, { onChange: this.filterList }),
      React.createElement(TodoList, { tasks: this.state.tasks, onDelete: this.handleDelete, filter: this.state.filter }))));



  }}


class FilterList extends React.Component {constructor(...args) {super(...args);_defineProperty(this, "state",
    { filter: '' });_defineProperty(this, "handleFilterChange",

    e => {
      console.log("Here");
      this.setState({
        filter: e.target.value });

      this.props.onChange(e.target.value);
    });}

  render() {
    return (
      React.createElement("div", { className: "filter-form" },
      React.createElement("input", {
        type: "text",
        class: "box",
        id: "filter",
        value: this.state.filter,
        onChange: this.handleFilterChange,
        placeholder: "Search with starting characters" })));


  }}



class SubmitForm extends React.Component {constructor(...args) {super(...args);_defineProperty(this, "state",
    { term: '' });_defineProperty(this, "handleAdd",

    e => {
      e.preventDefault();
      if (this.state.term === '')
      {
        alert("Cannot insert empty element");
        return;
      }
      this.props.onFormSubmit(this.state.term);
      this.setState({ term: '' });
    });}

  render() {
    return (
      React.createElement("form", { onSubmit: this.handleAdd },
      React.createElement("input", {
        type: "text",
        className: "input",
        placeholder: "Enter new item to list...",
        value: this.state.term,
        onChange: e => this.setState({ term: e.target.value }) }),
      React.createElement("button", { className: "button" }, "Add Item")));


  }}



const Header = props => {
  return (
    React.createElement("div", { className: "card-header" },
    React.createElement("h1", { className: "card-header-title header" }, "You have ",
    props.todosCount, " Todos!")));



};

const TodoList = props => {
  var todos = "";
  let taskName = props.filter.toLowerCase();
  console.log(taskName);
  if (props.filter == "")
  {
    todos = props.tasks.map((todo, index) => {
      return React.createElement(Todo, { content: todo, key: index, id: index, onDelete: props.onDelete });
    });
  } else
  if (props.filter != "")
  {
    var filteredList = props.tasks.filter(task => task.includes(taskName));
    todos = filteredList.map((todo, index) => {
      return React.createElement(Todo, { content: todo, key: index, id: index, onDelete: props.onDelete });
    });
  }


  return (
    React.createElement("div", { className: "list-wrapper" },
    todos));


};

const Todo = props => {
  return (
    React.createElement("button", { class: "list-item box", onClick: () => {props.onDelete(props.id);} }, props.content));

};

ReactDOM.render(
React.createElement(App, null), document.querySelector('#root'));