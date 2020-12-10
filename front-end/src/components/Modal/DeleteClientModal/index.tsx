import React from 'react';

import Modal from '..';
import Button from '../../Button';

import { Container } from './styles';

interface IModalProps {
  handleDeleteClient: () => void;
  isOpen: boolean;
  setIsOpen: () => void;
}

const DeleteClientModal: React.FC<IModalProps> = ({
  handleDeleteClient,
  isOpen,
  setIsOpen
}) => {
  return (
    <Modal isOpen={isOpen} setIsOpen={setIsOpen}>
      <Container>
        <button
          type="button"
          onClick={setIsOpen}
        >
          X
        </button>

        <strong>Would you like to delete this client?</strong>

        <section>
          <Button type="button" onClick={setIsOpen}>
            CANCEL
          </Button>

          <Button type="button" onClick={() => {
            setIsOpen();
            handleDeleteClient();
          }}>
            DELETE
          </Button>
        </section>
      </Container>
    </Modal>
  );
};

export default DeleteClientModal;
