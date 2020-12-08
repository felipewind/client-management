import styled from 'styled-components';

interface OptionContainerProps {
  optionSelectedIndex: number;
}

export const Container = styled.div<OptionContainerProps>`
  position: absolute;
  height: 100vh;
  width: 300px;
  background: #171e28;
  box-shadow: 2px 2px 6px 0 rgba(0, 0, 0, 0.16);

  header {
    display: flex;
    align-items: center;
    flex-direction: row;
    padding: 24px;

    svg {
      width: 40px;
      height: 40px;
      color: #1fbeff;
    }

    strong {
      margin-left: 12px;
      font-size: 20px;
      font-weight: 700;
      color: #fff;
    }
  }

  nav {
    div {
      &:nth-child(${props => props.optionSelectedIndex}) {
        background: #272D36;
      }
    }
  }
`;

export const OptionContainer = styled.div`
  display: flex;
  align-items: center;
  flex-direction: row;
  padding: 12px 24px;
  transition: background-color 0.2s;

  cursor: pointer;

  &:hover {
    background: #272D36;
  }

  div {
    display: flex;
    align-items: center;
    justify-content: center;

    width: 40px;
    height: 40px;

    svg {
      width: 30px;
      height: 30px;
      color: #1fbeff;
    }
  }

  strong {
    margin-left: 12px;
    font-size: 20px;
    font-weight: 500;
    color: #fff;
  }
`;
