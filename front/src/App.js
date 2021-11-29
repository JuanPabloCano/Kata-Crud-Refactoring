import React from 'react';
import { StoreProvider } from './Store';
import MainTodo from './Components/MainTodo';

function App() {
  return <StoreProvider>
    <MainTodo />
  </StoreProvider>
}

export default App;
