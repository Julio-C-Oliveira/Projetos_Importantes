from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class Tree(_message.Message):
    __slots__ = ("client_ID", "serialised_tree")
    CLIENT_ID_FIELD_NUMBER: _ClassVar[int]
    SERIALISED_TREE_FIELD_NUMBER: _ClassVar[int]
    client_ID: int
    serialised_tree: bytes
    def __init__(self, client_ID: _Optional[int] = ..., serialised_tree: _Optional[bytes] = ...) -> None: ...
