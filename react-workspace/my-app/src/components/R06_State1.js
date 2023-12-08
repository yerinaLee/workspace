import React, { useState } from 'react'; /* imrs */

/* 함수형 컴포넌트 (반환 값이 HTML 요소) */
const StateEx1 = ()=>{

  // let test = 'A';
  // 1) test : 상태 변수 명을 test로 지정 
  // 2) setTest : 상태 변수 test를 변경하는 함수
  // 3) userState('A') : 변수 test를 상태 변수로 사용할 것이고 초기값으로 'A'를 대입
  // -> 상태 변수로 지정된 test가 setTest 함수에 의해 변하게 될 경우 컴포넌트를 리랜더링 함.
  const [test, setTest] = useState('A');
  // useState라는 함수를 선택했을 때 0번인덱스(test)에는 'A'가, 1번 인덱스 setTest에는 'A'가 들어간다
  // setTest는 setter개념

  const testFn = ()=>{
    if(test === 'A') setTest('B');
    else setTest('A');

    console.log(test);
  }

  // 버튼 클릭 -> testFn 호출 -> setTest() 호출 -> 상태변수 test 변함 
  // -> 상태변수가 변했으니 컴포넌트 중 test를 사용하는 컴포넌트 리랜더링
  return(
    <>
      <h1>{test}</h1>
      <button onClick={testFn}>Change!!</button>
    </>
  );

}

export default StateEx1;