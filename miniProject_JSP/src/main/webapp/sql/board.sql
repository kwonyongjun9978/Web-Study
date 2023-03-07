CREATE TABLE board(
     seq NUMBER NOT NULL,               -- �۹�ȣ (������ ��ü �̿�)
     id VARCHAR2(20) NOT NULL,          -- ���̵� memId
     name VARCHAR2(40) NOT NULL,        -- �̸�  memName
     email VARCHAR2(40),                -- �̸��� memEmail
     subject VARCHAR2(255) NOT NULL,    -- ����
     content VARCHAR2(4000) NOT NULL,   -- ���� 

     ref NUMBER NOT NULL,               -- �׷��ȣ seq�� ���� ��ȣ
     lev NUMBER DEFAULT 0 NOT NULL,     -- �ܰ�
     step NUMBER DEFAULT 0 NOT NULL,    -- �ۼ���
     pseq NUMBER DEFAULT 0 NOT NULL,    -- ���۹�ȣ
     reply NUMBER DEFAULT 0 NOT NULL,   -- �亯��

     hit NUMBER DEFAULT 0,              -- ��ȸ��
     logtime DATE DEFAULT SYSDATE
 );

������ ��ü
CREATE SEQUENCE seq_board  NOCACHE NOCYCLE;