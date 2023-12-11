import React, { useState } from 'react';

/*------ useState 복습 ------*/

/* 함수형 컴포넌트 */ // 컴포넌트명은 대문자로 시작해야함
const InputName = ()=>{

  // 상태(State) : 컴포넌트의 변수
  // -> 변수 값이 변하면 컴포넌트가 리랜더링 됨
  // name : 상태 변수명
  // setName() : name 상태 변수값을 변경하는 setter
  // useState('') : name을 상태 변수 지정 + 초기값 ('')
  const [name, setName] = useState('');

  // 함수형 컴포넌트는 리턴문에서 HTML을 반환
  return(
    /* jsx(JavaScript XML) : JS 내부에서 마크업 언어 작성하는 문법*/
    <div>
      <p>이름을 입력하세요</p>

      <input type='text' onChange={ (e)=>{setName(e.target.value)} } />

      <h3>{name}</h3>
    </div>
  );
}



/* 함수형 컴포넌트 */
const TodoList = ()=>{

  /* TodoList(할 일 목록) 만들기 */

  /* 할 일 목록을 저장할 객체 배열을 상태 변수 선언 */
  const [todos, setTodos] = useState([
    { text : '프로젝트', completed : false },
    { text : '점심먹기', completed : false },
    { text : '출석하기', completed : true }
  ]);


  /* 체크박스 체크 변경 시 수행할 함수(이벤트 핸들러) */
  const todoChange = (index)=>{
    
    // todos 깊은 복사 후, 지정된 index의 completed 값을 변경
    // -> setTodos(복사한 객체 배열) -> 컴포넌트 리랜더링

    // ...(나열/전개 연산자) : 배열 또는 객체의 가장 바깥쪽 괄호를 푸는 것
    const newTodos = [...todos]; // 깊은 복사

    // 지정된 index의 completed 값을 변경
    newTodos[index].completed = !newTodos[index].completed;

    setTodos(newTodos);
  };


  /* todos에 새로운 할 일 추가 */
  const InputTodo =()=>{

    const [inputText, setInputText] = useState('');
    
    /* 추가하기 버튼 클릭 시 todos에 할 일 추가하는 함수(이벤트 핸들러) */
    const addTodo = ()=>{

      // todos 요소와 같은 모양의 객체
      const todo = {text : inputText, completed : false};

      // 깊은 복사 + todo 추가
      const newTodos = [...todos, todo];

      // 상태변수 변경 -> 리랜더링
      setTodos(newTodos);
      setInputText(''); // 이전 입력한 할일 지우기
    }

    return(
      <div>
        {/* <h1>Todo List</h1> */}
        <h4>할 일 추가</h4>
        <input type='text' onChange={ (e) => { setInputText(e.target.value) } }/>
        <button onClick={ addTodo }>추가하기</button>

      </div>
    );
  }

  return(
    <>
      <h2>State 복습</h2>
      <InputName/>
      <hr/>

      {/* 할 일 추가 */}
      <InputTodo/>

      {/* 할일 목록 */}

      {/* 기존배열.map( (배열요소, 인덱스) => { return 값; } ) 
      
        - 기존 배열의 요소를 순차 접근(향상된 for문)
          -> 매개변수 중 배열 요소에 기존 배열의 요소가 하나씩 대입

        - return되는 값들을 모아서 새로운 배열을 반환
      */}
      <ul>
        {todos.map( (item, index) => { return(
          <li>
            <input type='checkbox'checked={item.completed} onChange={ () => {todoChange(index)} }/>

            <span className={item.completed? 'completed': ''}>{item.text}</span>

          </li>
        );} )}
      </ul>
    </>
  );
}

export default TodoList;