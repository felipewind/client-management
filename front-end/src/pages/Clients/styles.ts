import styled, { css } from 'styled-components';
import { shade } from 'polished';

interface HeaderContainerProps {
  clientIsSelected: boolean;
}

interface ClientContainerProps {
  isSelected: boolean;
}

export const Container = styled.div`
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

    h1 {
      font-size: 24px;
      font-weight: 500;
      color: #cfd0d3;
      padding: 0;
    }

    svg {
      margin-left: 6px;
      width: 30px;
      height: 30px;
      color: #cfd0d3;
    }

      ${props => props.clientIsSelected && css`
        cursor: pointer;

        h1 {
          color: #3f454e;
          transition: color 0.2s;
        }

        svg {
          color: #3f454e;
          transition: color 0.2s;
        }

        &:hover {
          h1 {
            color: ${shade(0.2, '#3f454e')};
          }

          svg {
            color: ${shade(0.2, '#3f454e')};
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

export const DataContainer = styled.div`
  width: 100%;
  height: 90%;
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

  &:hover {
    background: #cfd0d3;
  }

  ${props => props.isSelected && css`
    background: #cfd0d3;
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
