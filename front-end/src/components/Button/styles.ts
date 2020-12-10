import styled from 'styled-components';
import { shade } from 'polished';

export const Container = styled.button`
  border-radius: 10px;
  box-shadow: 2px 2px 6px 0 rgba(0, 0, 0, 0.16);

  background: #3f454e;
  border: 0;
  color: white;
  font-size: 24px;
  font-weight: 700;
  transition: background-color 0.2s;

  &:hover {
    background: ${shade(0.2, '#3f454e')};
  }
`;
