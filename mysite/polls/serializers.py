from polls.models import Poll
from rest_framework import serializers

class PollsSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model=Poll
        fields = ('question', 'pub_date')
