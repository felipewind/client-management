import styled, { css, keyframes } from 'styled-components';
import { shade } from 'polished';

const appearFromLeft = keyframes`
  from {
    transform: translateX(100%);
  }
  to {
    transform: translateX(0);
  }
`;

interface HeaderContainerProps {
  clientIsSelected: boolean;
}

interface ClientContainerProps {
  isSelected: boolean;
}

type DataContainerProps = HeaderContainerProps;

type ClientDetailsContainerProps = DataContainerProps;

export const ClientAdditionContainer = styled.div`
  margin-left: 300px;
  padding: 64px 32px;
  height: 100vh;

  display: flex;
  flex-direction: column;

  > button {
    position: absolute;
    right: 0;
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
      margin-top: 32px;
    }
  }
`;

export const ClientsListContainer = styled.div`
  position: relative;
  margin-left: 300px;
  padding: 64px 32px;
  height: 100vh;
`;

export const HeaderContainer = styled.header<HeaderContainerProps>`
  display: flex;
  align-items: center;
  justify-content: space-between;

  border-bottom: 1px solid #3f454e;
  padding-bottom: 24px;

  strong {
    font-size: 32px;
    font-weight: 700;
    color: #3f454e;
  }

  div {
    display: flex;
    align-items: center;

    section {
      display: flex;
      align-items: center;
      margin-right: 24px;
      position: relative;

      h1 {
        font-size: 24px;
        font-weight: 500;
        color: #cfd0d3;
        padding: 0;
      }

      > button {
        background: none;
        border: 0;
        width: auto;

        svg {
          margin-left: 6px;
          width: 30px;
          height: 30px;
          color: #cfd0d3;
        }
      }

      ${props => props.clientIsSelected && css`
        h1 {
          color: #3f454e;
          transition: color 0.2s;
        }

        > button {
          svg {
            color: #3f454e;
            transition: color 0.2s;
          }
        }

        &:hover {
          h1 {
            color: ${shade(0.2, '#3f454e')};
          }

          > button {
            svg {
              color: ${shade(0.2, '#3f454e')};
            }
          }
        }
      `}
    }

    button {
      width: 150px;
      height: 50px;
    }
  }
`;

export const DataContainer = styled.div<DataContainerProps>`
  width: 100%;
  height: ${props => props.clientIsSelected ? '50%' : '90%'};
  display: flex;
  flex-direction: column;

  nav {
    padding: 24px 0;
    width: 100%;
    max-height: 100%;
    overflow-y: auto;
  }
`;

export const DescriptionContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  margin-top: 24px;

  border-bottom: 1px solid #3f454e;
  padding: 0 12px 12px 12px;

  strong {
    font-size: 20px;
    font-weight: 700;
    color: #3f454e;

    &:nth-child(1) {
      width: 30%;
    }

    &:nth-child(2) {
      width: 30%;
    }

    &:nth-child(3) {
      width: 25%;
    }

    &:nth-child(4) {
      width: 15%;
    }
  }
`;

export const ClientContainer = styled.div<ClientContainerProps>`
  display: flex;
  align-items: center;
  justify-content: space-between;

  cursor: pointer;
  width: 100%;
  padding: 12px;
  transition: background-color 0.2s;

  & + div {
    border-top: 1px solid #cfd0d3;
  }

  &:last-child {
    border-bottom: 1px solid #cfd0d3;
  }

  &:hover {
    background: #cfd0d3;
  }

  ${props => props.isSelected && css`
    background: ${shade(0.2, '#cfd0d3')};

    &:hover {
      background: ${shade(0.2, '#cfd0d3')};
    }
  `}

  section {
    width: 30%;
    display: flex;
    align-items: center;

    div {
      display: flex;
      align-items: center;
      justify-content: center;

      width: 40px;
      height: 40px;
      background: #3f454e;
      border-radius: 50%;

      svg {
        width: 25px;
        height: 25px;
        color: #1fbeff;
      }
    }

    strong {
      font-size: 18px;
      font-weight: 700;
      color: #3f454e;
      margin-left: 12px;
    }
  }

  > strong {
    font-size: 18px;
    font-weight: 700;
    color: #3f454e;

    &:nth-child(2) {
      width: 30%;
    }

    &:nth-child(3) {
      width: 25%;
    }

    &:nth-child(4) {
      width: 15%;
    }
  }
`;

export const ManageClientPopup = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;

  position: absolute;
  width: auto;
  right: 0;
  background: #fff;

  margin-bottom: -150px;
  border-radius: 6px;
  box-shadow: 2px 2px 6px 0 rgba(0, 0, 0, 0.16);

  button {
    background: none;
    border: 0;
    font-size: 20px;
    font-weight: 400;
    box-shadow: 0 0 2px 0 rgba(0, 0, 0, 0.16);
    transition: background-color 0.2s;

    &:hover {
      background: ${shade(0.2, '#fff')};
    }

    &:first-child {
      border-radius: 6px 6px 0 0;
      color: #3f454e;
    }

    &:last-child {
      border-radius: 0 0 6px 6px;
      color: #ff3333;
    }
  }
`;

export const ClientDetailsContainer = styled.div<ClientDetailsContainerProps>`
  position: absolute;
  bottom: 0;
  overflow-y: hidden;

  animation: ${appearFromLeft} 1s;

  ${props => !props.clientIsSelected ? css`
    display: none;
  ` : css`
    display: flex;
  `}

  width: 100%;
  height: 30%;
  margin-left: 300px;
  background: #fff;
  box-shadow: 2px 2px 6px 2px rgba(0, 0, 0, 0.16);

  flex-direction: row;

  section {
    display: flex;
    align-items: center;

    &:first-child {
      justify-content: center;
      box-shadow: 0 0 2px 0 rgba(0, 0, 0, 0.16);

      padding: 0 32px;
    }

    &:last-child {
      box-shadow: 0 2px 0 0 rgba(0, 0, 0, 0.16);
    }

    > div {
      display: flex;
      align-items: center;
      justify-content: center;

      width: 120px;
      height: 120px;
      background: #3f454e;
      border-radius: 50%;

      svg {
        width: 80px;
        height: 80px;
        color: #1fbeff;
      }
    }

    > article {
      display: flex;
      justify-content: center;
      flex-direction: column;

      padding: 32px;

      strong {
        margin-bottom: 6px;
        font-size: 24px;
        font-weight: 400;
        color: #cfd0d3;
      }

      h2 {
        padding: 0;
        font-size: 20px;
        font-weight: 500;
        color: #3f454e;

        & + strong {
          margin-top: 12px;
        }
      }
    }
  }
`;
