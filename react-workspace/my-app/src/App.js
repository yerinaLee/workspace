import './App.css';
// import 여기서사용할 이름 from js파일 경로;
import ClassComponent from './components/R01_ClassComponent';
import FunctionComponent from './components/R02_FunctionComponent';

import Props1 from './components/R03_Props1';
import Props2 from './components/R04_Props2';
import Props3 from './components/R05_Props3';

import State1 from './components/R06_State1';
import State2 from './components/R07_State2';
import State3 from './components/R08_State3';

/* ================================================================== */
/* 
  - React의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다
  - 여러 요소를 반환하고 싶을때 부모요소로 묶어준다!
*/
/* ================================================================== */
function App() { // 부모 컴포넌트
  return (
    /* <></> : (fragment, 조각) : 반환되는 요소를 감싸는 태그, 해석 X(th:block느낌) */
    <>
      <h1>테스트</h1>
      {/* <ClassComponent /> */}  {/* 자식 컴포넌트 */}

      {/* jsx 주석 */}
      {/* <ClassComponent /> */}
      <hr/> {/* 시작하고 바로 종료된다고 표시해줘야함! */}

      {/* <FunctionComponent /> */}
      {/* <FunctionComponent /> */}

      {/*<hr/>
      <Props1 />
      <Props1 name='홍길동' num='1'/>
      <Props1 name='전원우' num='2'/>

      <hr/>
      <Props2 name='전원우' age='27' address='서울 용산구' gender='남자'/>
      <Props2 name='이지훈' age='28' address='부산 수영구' gender='남자'/>

      <hr/>
      <Props3 name='윤정한'/>
      <Props3 name='최승철'/> */}

      <State1/>
      <State2 init={10}/>
      <State2 init={0}/>

      <hr />
      <State3/>

    </>
  );
}

export default App;
