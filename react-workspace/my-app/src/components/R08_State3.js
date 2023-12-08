import React, { useState } from 'react';

/* 자식 컴포넌트 */
const Id = (props)=>{

  console.log(props);
  console.log(props.handler);

  return(
    <div>
      <label htmlFor='id'>ID : </label>
      <input type='text' id='id' onChange={props.handler}/>
    </div>
  );
};

/* 자식 컴포넌트 */
const Pw = ({handler})=>{ 
  // 전달 받은 props 객체에서 key가 'handle'인 요소의 value(함수)를 handler 매개변수에 저장
  // == const {handler} = props;

  return(
    <div>
      <label htmlFor='pw'>PW : </label>
      <input type='password' id='pw' onChange={handler}></input>
    </div>
  );
};

/* 부모 컴포넌트 */
const StateLiftingUp = ()=>{

  // 상태 변수 선언
  const [inputId, setInputId] = useState('');
  const [inputPw, setInputPw] = useState('');

  // 자식 컴포넌트에서 사용할 이벤트 핸들러 작성
  const idHandler = (e)=>{
    // e : 이벤트 객체
    setInputId(e.target.value);
  };

  const pwHandler = (e)=>{
    setInputPw(e.target.value);
  };

  return(
    <div>
      <Id handler={idHandler} />
      <Pw handler={pwHandler}/>

      <div>
        <button disabled={inputId.length === 0 || inputPw.length === 0}>Login</button>
      </div>

    </div>
  );
};

export default StateLiftingUp;