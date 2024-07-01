from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class Request_Server(_message.Message):
    __slots__ = ["client_ID"]
    CLIENT_ID_FIELD_NUMBER: _ClassVar[int]
    client_ID: int
    def __init__(self, client_ID: _Optional[int] = ...) -> None: ...

class Server_Settings(_message.Message):
    __slots__ = ["trees_by_client"]
    TREES_BY_CLIENT_FIELD_NUMBER: _ClassVar[int]
    trees_by_client: int
    def __init__(self, trees_by_client: _Optional[int] = ...) -> None: ...

class Forest_CLient(_message.Message):
    __slots__ = ["client_ID", "serialised_tree"]
    CLIENT_ID_FIELD_NUMBER: _ClassVar[int]
    SERIALISED_TREE_FIELD_NUMBER: _ClassVar[int]
    client_ID: int
    serialised_tree: bytes
    def __init__(self, client_ID: _Optional[int] = ..., serialised_tree: _Optional[bytes] = ...) -> None: ...

class Forest_Server(_message.Message):
    __slots__ = ["serialised_tree"]
    SERIALISED_TREE_FIELD_NUMBER: _ClassVar[int]
    serialised_tree: bytes
    def __init__(self, serialised_tree: _Optional[bytes] = ...) -> None: ...

class OK(_message.Message):
    __slots__ = ["ok"]
    OK_FIELD_NUMBER: _ClassVar[int]
    ok: int
    def __init__(self, ok: _Optional[int] = ...) -> None: ...
