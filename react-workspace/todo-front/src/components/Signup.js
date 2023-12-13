import React, { useState } from 'react';

/* 회원 가입 컴포넌트 */
const SignupContainer = () => {

  const [id, setId] = useState('');
  const [pw, setPw] = useState('');
  const [pwCheck, setPwCheck] = useState('');
  const [name, setName] = useState('');
  const [result, setResult] = useState('');

  // 아이디 중복 검사
  const [idValidation, setIdValidation] = useState(false);
  // false -> 사용 불가
  // true -> 사용 가능

  /* 아이디 중복 검사 이벤트 핸들러*/
  const idCheck = (inputId)=>{

    // inputId : 현재 입력한 ID
    setId(inputId);

    // 4글자 미만이면 중복 검사 X
    if(inputId.trim().length < 4){
      setIdValidation(false); // 중복검사 여부 상태 변수
      return;
    }

    // 비동기로 아이디 중복검사 수행
    fetch('/idCheck?id=' + inputId)
    .then(resp => resp.text())
    .then(result => {

      // 중복이 아닐 때 true, 중복이면 false
      if( Number(result) === 0) setIdValidation(true);
      else            setIdValidation(false);
    })
    .catch()
  }

  /* 회원 가입 이벤트 핸들러*/
  const signup = ()=>{

    // 아이디 유효하지 않으면 가입 X
    if(!idValidation){
      alert('아이디가 유효하지 않습니다')
      return;
    }

    // 비밀번호, 비밀번호 확인이 일치하지 않으면 가입 X
    if(pw !== pwCheck){
      alert('비밀번호가 일치하지 않습니다')
      return;
    }

    /* 회원가입 비동기 요청 */
    const inputObj = {};
    inputObj.id = id;
    inputObj.pw = pw;
    inputObj.name = name;

    fetch("/signup", {
      method : "POST",
      headers : {"Content-Type" : "application/json"},
      body : JSON.stringify(inputObj)
    })
    .then(resp => resp.text())
    .then(result => {
      if(Number(result) > 0){

        setResult('회원 가입 성공');
        setId('');
        setPw('');
        setPwCheck('');
        setName('');

      } else {
        setResult('회원 가입 실패');
      }
    })
  }


  return (
    <div className="signup-container">
      <label>
        ID :
        <input type="text"
          onChange={e => {idCheck(e.target.value)}}
          value={id}
          className={idValidation ? '' : 'id-error'}
        />
      </label>

      <label>
        PW :
        <input type="password"
          onChange={e => { setPw(e.target.value) }}
          value={pw}
        />
      </label>

      <label>
        PW CHECK :
        <input type="password"
          onChange={e => { setPwCheck(e.target.value) }}
          value={pwCheck}
        />
      </label>

      <label>
        NAME :
        <input type="text"
          onChange={e => { setName(e.target.value) }}
          value={name}
        />
      </label>

      <button onClick={signup}>가입하기</button>

      <hr />

      <h3>{result}</h3>
    </div>
  );
}

export default SignupContainer;