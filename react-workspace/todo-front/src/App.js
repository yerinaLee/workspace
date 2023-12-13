import React, { useState } from 'react';

import './App.css'; 
import TodoListContext from './components/TodoListContext';
import SignupContainer from './components/Signup';
import LoginComponent from './components/Login';
import TodoListComponent from './components/TodoList';

/*  App 컴포넌트 (최상위 컴포넌트) */
function App() {
  /* 상태 변수(값이 변하면 컴포넌트 리랜더링) */

  // 회원 가입창 보이기/숨기기
  const [signupView, setSignupView] = useState(false);

  // 로그인한 회원 정보 저장
  const [loginMember, setLoginMember] = useState(null);

  // 로그인한 회원의 할 일 목록 저장
  const [todoList, setTodoList] = useState([]);

  return (
    <TodoListContext.Provider value={ {loginMember, setLoginMember, todoList, setTodoList} }>
      <button onClick={ ()=>{ setSignupView(!signupView) } }>
      { signupView ? ('회원 가입 닫기') : ('회원 가입 열기')}
      </button>

      {/* 회원가입 화면 */}
      <div className='signup-wrapper'>
        {/* signup.js에서 import한 컴포넌트 */}

        {/* signupView가 true인 경우에만 화면에 출력 */}
        {/* 조건식 && (true인 경우 실행) */}
        {/* &&: 좌변이 true일 때 우변을 실행하겠다는 JS 코드 */}
        { signupView === true && (<SignupContainer/>) } 
      </div>

      <h1>Todo List</h1>

      {/* 로그인 컴포넌트 */}
      <LoginComponent/>


      <hr/>

      {/* 로그인 되었을 때 로그인한 회원의 TodoList 출력 */}
      { loginMember && (<TodoListComponent/>)}

    </TodoListContext.Provider>
  );
}

export default App;
