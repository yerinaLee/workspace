import React, { useState, createContext, useContext } from 'react';

/* 1. Context 객체 생성 */
const TestContext = createContext();

/* 4. 손주(2단계 하위) 컴포넌트 */
const GrandChild = ()=>{

   // {"number" : number , "setNumber" : setNumber}
  const {number, setNumber} = useContext(TestContext);

  return (
    <>
      <h3>GrandChild Component</h3>
      <input type='number' onChange={ (e) => { setNumber(e.target.value) }}
            value={number}/>
    </>
  );
}

/* 3. 자식(1단계 하위) 컴포넌트 */
const Child = ()=>{
  return (
    <>
      <h1>Child Component랍니다</h1>
      <GrandChild/>
    </>
  );
}

/* 3. 부모 컴포넌트 */
const Parent = ()=>{

  // 상태 변수 선언
  const [number, setNumber] = useState(0);

  return (

    /* Context에 값을 추가 -> 모든 하위 컴포넌트에게 제공 */
    // {"number" : number , "setNumber" : setNumber}
    <TestContext.Provider value={ {number,setNumber} }>
      <h1>Parent Component</h1>

      <h1>
        GrandChild에서 전달된 값 :
        <span className='color-red'> {number} </span>
      </h1>

      <Child/>

    </TestContext.Provider>
  );
}

export default Parent;