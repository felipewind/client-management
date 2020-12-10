import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  display: flex;
  flex-direction: column;

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

  form {
    display: flex;
    justify-content: center;
    flex-direction: column;

    section {
      display: flex;
      justify-content: center;
      flex-direction: row;
      margin-top: 32px;

      > div {
        strong {
          font-size: 20px;
          font-weight: 400;
          color: #3f454e;
        }

        div {
          margin: 8px 0 16px 0;
          height: 50px;

          &:last-child {
            margin-bottom: 0;
          }
        }

        &:first-child {
          margin-right: 32px;
        }

        &:last-child {
          margin-left: 32px;
        }
      }
    }

    button {
      align-self: center;
      width: 150px;
      height: 50px;
      margin: 32px 0;
    }
  }
`;
