import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  > button {
    position: absolute;
    right: 0;
    margin-top: 16px;
    margin-right: 32px;
    background: none;
    border: 0;
    font-size: 32px;
    font-weight: 700;
  }

  > strong {
    align-self: center;
    font-size: 32px;
    font-weight: 700;
    color: #3f454e;
    margin-top: 32px;
  }

  section {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 32px 0;

    button {
      width: 150px;
      height: 50px;

      &:first-child {
        margin-right: 16px;
      }

      &:last-child {
        background: #ff3333;
        margin-left: 16px;
      }
    }
  }
`;
