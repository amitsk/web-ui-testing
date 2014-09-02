from polls.models import Poll
from rest_framework import viewsets
from  polls.serializers import PollsSerializer

class PollViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = Poll.objects.all()
    serializer_class = PollsSerializer


# Create your views here.
