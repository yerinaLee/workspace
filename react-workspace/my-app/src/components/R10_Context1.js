import React, {createContext, useContext} from 'react';

/* 1. Context 객체 생성 */
const TestContext = createContext();

// 함수를 변수에 대입하는 형태로 만들때에는 위에서 아래로 해석되기때문에,
// 함수가 우선 위에 있어야한다!

/* 4. 손주 (2단계 하위) 컴포넌트  */
const GrandChild = () =>{
  const temp = useContext(TestContext); // TestContext에 저장된 값을 temp에 대입
  
  return(
    <>
      <h3>GrandChild component ( {temp} )</h3>
    </>
  )
}

/* 3. 자식 (1단계 하위) 컴포넌트 */
const Child = ()=>{
  return(
    <>
      {/* 하위 컴포넌트인 GrandChild로 전달하는 값이 없음 */}
      <h2>Child component</h2>
      <GrandChild/>
    </>
  );
}

/* 2. 부모 컴포넌트 */
const Parent = ()=>{
  return(
    /* Context에 값을 추가 -> 모든 하위 컴포넌트에게 제공 */
    <TestContext.Provider value='Parent에서 전달한 값'>

      <h1>Parent Component</h1>
      <Child/>

    </TestContext.Provider>
  )
}

export default Parent;