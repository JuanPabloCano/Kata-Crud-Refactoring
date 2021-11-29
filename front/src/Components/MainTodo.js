import React from 'react';
import Form from './Todo/Form';
import List from './Todo/List';

const MainTodo = () => {
    return (
        <>
            <div className="container">
                <div className="title"><h3>To-Do List</h3></div>
                <Form />
                <List />
            </div>
        </>
    )
}

export default MainTodo;