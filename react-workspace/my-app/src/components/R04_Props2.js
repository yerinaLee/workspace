import React from 'react'; /* imr */

const PropsEx2 = (props) => {

  console.log('PropsEx2');
  console.log(props);

  // props라는 객체에서 
  // {} 내부에 작성된 변수명과 같은 key가 존재하면
  // 변수에 value를 대입
  let {name, age, address, gender} = props;

  return(
    /* className(React) == class(HTML) */
    <ul className='info'>
      <li>이름 : {name}</li>
      <li>나이 : {age}</li>
      <li>주소 : {gender}</li>
      <li>성별 : {address}</li>
    </ul>
  );

}

export default PropsEx2;