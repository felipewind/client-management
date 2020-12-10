import styled, { css } from 'styled-components';

interface ContainerProps {
  isFocused: boolean;
  isFilled: boolean;
  isErrored: boolean;
}

export const Container = styled.div<ContainerProps>`
  padding: 12px 16px;
  width: 100%;

  display: flex;
  align-items: center;

  background: white;

  border-radius: 6px;
  box-shadow: 2px 2px 6px 0 rgba(0, 0, 0, 0.16);
  border: solid 0.5px #3f454e;

  ${props =>
    props.isErrored &&
    css`
      border-color: #c53030;
    `}

  ${props =>
    props.isFocused &&
    css`
      border-color: #3f454e;
    `}

  ${props =>
    props.isFilled &&
    css`
      color: #3f454e;
    `}

  input {
    flex: 1;
    background: transparent;
    border: 0;
    font-weight: 400;
  }

  svg {
    margin-right: 16px;
  }
`;
